<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Blank Page</title>
    <%@include file="include/css.jsp"%>
</head>
<body class="hold-transition skin-black-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="include/navhead.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="include/sider.jsp">
        <jsp:param name="menu" value="home"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                悟空传
                <small>it all starts here</small>
            </h1>
        </section>
        <section class="content-header">
            <td>

                <small>在今何在的《悟空传》中，那种曾经代表正义、充当英雄具有典型化、脸谱化的形象发生了彻底的转化。每一个形象都被赋予了丰富与复杂的价值内涵，超越了《西游记》中形象的单向性和特定化。每一个形象自身都矛盾重重、行动不居、让人琢磨不透。他们都超越了原有的形象阐释框架和解释规范，不断冲击和修改我们已有的期待视野。如果我们再用正义与邪恶这个二元际准来划分《悟空传》中的人物形象，我们往往会显得捉襟见肘、苍白无力。从这个意义而言，《悟空传》对人物形象的反类型化策略，极大地增加了我们对生存状态、生命价值、个体性格那些内在冲突的悖论、丰富性与多样性的理解。 在《西游记》的取经故事中，唐僧师徒所遭遇的很多磨难都是由于神仙、佛的疏忽或是监管不力而造成的。由于神仙们的疏忽与监管不力，导致其坐骑或者属下下凡危害人间，可最后的结果是它们是神所豢养的，什么处罚都没有，被带上了天庭回归了它原有的生活，危害人间只是游戏一番，调剂一下天庭枯燥、乏味的生活而已。而作为他们的主人一点责任都不用承担。反而是孙悟空他们面对这些始作诵者要感恩戴德。就因为他们是神。他们所做的都是对的，是权威，其他人只有服从。《悟空传》中的悟空是反对神的，他的出生就决定了他不是神，他是由石头变的，是神之外的生灵，而他认为神和万物都是平等的，而神却认为他们高人—等，要所有的万物都诚服于自己的管理之下。而悟空却要改变这一切，与神作斗争，虽然每次伤痕累累，但他却乐此不彼。《悟空传》中的悟空，在某种意义上，就是一个隐喻。它表征着对这种神圣不证自明的中心、等级制度合法性的质疑，表征着对权威的对抗和消解中心的努力。 [7] 《悟空传》中的神是作者否定的对象，他们被描绘成猥琐、自私、贪生怕死的形象，玉帝懦弱无能、王母蛮横霸道、如来的唯我独尊以及众神自保性命的嘴脸暴露无遗，难以让人对这群神仙产生敬意。王母娘娘在书中被描绘成一个患有歇斯底里症的神经质女人，她的权力至高无上，天庭的一切规章制度就是她的意愿，不只是高高在上的诸位神仙，就连在古典作品中处于完全支配地位的玉皇大帝在这里，也不敢当众违背她的任何意愿。</small>
            </td>
        </section>

        <!-- Main content -->
        <section class="content">

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="include/js.jsp"%>
</body>
</html>