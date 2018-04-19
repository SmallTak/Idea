package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.service.RolesPermissionService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**动态定义权限和URL的关系
 *
 * @Author Reich
 * @Date: 2018/4/18 12:18
 */
public class CustomerFilterChainDefinition {

    @Autowired
    private RolesPermissionService rolesPermissionService;

    private Logger logger = LoggerFactory.getLogger(CustomerFilterChainDefinition.class);

    private String filterChainDefinitions;

    private AbstractShiroFilter shiroFilter;

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public void setShiroFilter(AbstractShiroFilter shiroFilter) {
        this.shiroFilter = shiroFilter;
    }

    /**
     * Spring容器启动时调用
     */
    @PostConstruct
    public synchronized void init() {
        logger.info("------刷新URL权限-----------");
        //清除原有的URL权限
        getFilterChainManager().getFilterChains().clear();
        //加载现有的URL权限
        load();
        logger.info("------刷新URL权限结束-----------");
    }
    /**
     * 重新加载URL权限
     */
    public synchronized void updateUrlPermission() {
        logger.info("------刷新URL权限-----------");
        //清除原有的URL权限
        getFilterChainManager().getFilterChains().clear();
        //加载现有的URL权限
        load();
        logger.info("------刷新URL权限结束-----------");
    }

    /**
     * 加载URL和权限的对应关系
     */
    public synchronized void load(){

        Ini ini = new Ini();
        //该方法会读取spring-shiro.xml中的filterChainDefinitions属性值
        ini.load(filterChainDefinitions);

        //从数据库中查找所有的权限
        List<Permission> permissionList = rolesPermissionService.findAllPermission();

        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

        for (Permission permission : permissionList){
            section.put(permission.getUrl(),"perms["+permission.getPermissionCode()+"]");
        }
        section.put("/**","user");

        //URL和权限的关系设置到shiroFilter中(源码中该对象的实例存放的就是一个长度为11的键值对(也就是过滤器))
        DefaultFilterChainManager defaultFilterChainManager = getFilterChainManager();
        for(Map.Entry<String,String> entry : section.entrySet()) {
            defaultFilterChainManager.createChain(entry.getKey(),entry.getValue());
        }

    }

    public DefaultFilterChainManager getFilterChainManager() {
        PathMatchingFilterChainResolver pathMatchingFilterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager defaultFilterChainManager = (DefaultFilterChainManager) pathMatchingFilterChainResolver.getFilterChainManager();
        return defaultFilterChainManager;
    }
}
