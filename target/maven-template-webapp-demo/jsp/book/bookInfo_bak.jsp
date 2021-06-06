<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>算法导论</title>
    <link rel="shortcut icon" href="img/douban.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/movieInfo.css"/>

    <!-- MD5加密 -->
    <script type="text/javascript" src="js/md5.js"></script>


    <!-- MDB -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/mdb.min.js"></script>

    <!--rating-->
    <link rel="stylesheet" href="css/jquery.raty.css"/>
    <script type="text/javascript" src="js/jquery.raty.js"></script>

</head>
<script>
</script>
<body style="font-size: 14px">
<div class="container ml-auto">
    <div id="article" class="float-left mt-3" style="width: 700px">

        <!-- 图书标题 -->
        <h1 class="title mb-4">
            <span id="bookTitle">算法导论 Introduction to Algorithms</span>
            <span style="color:#888" id="year">(2006)</span>
        </h1>
        <div id="content1" class="clearfix">
            <!-- 图书封面 和 图书信息 -->
            <div id="subContent1" class="float-left" style="width: 500px">
                <!-- 图书封面 -->
                <div id="bookCoverDiv" class="float-left" style="max-width:135px">
                    <img id="bookCover" src="https://gitee.com/a-shy-coder/blog-images/raw/master/s1959967.jpg"
                         class="cover">
                </div>
                <!-- 图书信息 -->
                <div id="bookInfo" class="float-left ml-3" style="max-width:333px">
                    <span class="greyText">作者: </span><span id="author"><a href="#">Thomas H.Cormen</a></span>
                    <br>
                    <span class="greyText">出版社: </span><span id="publisher">机械工业出版社</span>
                    <br>
                    <span class="greyText">原作名: </span><span id="originName">Introduction to Algorithms</span>
                    <br>
                    <span class="greyText">出版日期: </span><span id="releaseDate">2006-09-01</span>
                    <br>
                    <span class="greyText">页数: </span><span id="pageCount">754</span>
                    <br>
                    <span class="greyText">装帧: </span><span id="binding">平装</span>
                    <br>
                </div>
            </div>
            <!-- 图书评分与收藏 -->
            <div id="subContent2" class="float-left ml-4 borderLeft pl-2" style="width: 170px">
                <!-- 评分 -->
                <div class="pb-3">
                    <div style="color: #9b9b9b" class="mb-2">
                        绿豆芽评分
                    </div>
                    <div class="ratingText float-left mr-2">9.3</div>
                    <div id="rating"></div>
                    <script>
                        $(document).ready(function () {
                            $("#rating").raty({
                                path: 'img',
                                half: true,
                                halfShow: true,
                            });
                        })
                    </script>
                    <div class="rating_sum">
                        5118人评价
                    </div>
                </div>
                <!-- 用户评价 -->
                <div class="pb-3">
                    <span style="color: #9b9b9b" class="mb-2">
                        您的评分:
                    </span>
                    <span id="userRating"></span>
                    <script>
                        $(document).ready(function () {
                            $("#userRating").raty({
                                path: 'img',
                                half: true,
                                halfShow: true,

                            });
                        })
                    </script>
                </div>
                <!-- 收藏 -->
                <div id="collection" class="pt-3 text-center borderTop">
                    <button class="btn btn-warning btn-sm" id="collectionBtn" type="button"><i class="far fa-star"></i> 收藏</button>
                </div>
            </div>
        </div>

        <!-- 图书简介 -->
        <div id="content2" class="clearfix mt-4">
            <h2 id="bookInfoTitle" class="contentTitle">算法导论内容简介  · · · · · ·</h2>
            <div id="bookInfoContent">
                　这本书深入浅出，全面地介绍了计算机算法。对每一个算法的分析既易于理解又十分有趣，并保持了数学严谨性。本书的设计目标全面，适用于多种用途。涵盖的内容有：算法在计算中的作用，概率分析和随机算法的介绍。书中专门讨论了线性规划，介绍了动态规划的两个应用，随机化和线性规划技术的近似算法等，还有有关递归求解、快速排序中用到的划分方法与期望线性时间顺序统计算法，以及对贪心算法元素的讨论。此书还介绍了对强连通子图算法正确性的证明，对哈密顿回路和子集求和问题的NP完全性的证明等内容。全书提供了900多个练习题和思考题以及叙述较为详细的实例研究。
            </div>
            <div id="side" class="float-right">
            </div>
        </div>

        <!-- 图书作者 -->
        <div id="content3" class="clearfix mt-4">
            <h2 id="bookAuthorTitle" class="contentTitle">算法导论的作者 · · · · · · </h2>
            <ul id="authorList" class="authorUl">
                <li class="authorLi m-2">
                    <a href="authorId!!!!!!!">
                        <img id="authorImg" class="authorImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/author-default-medium.png">
                        <div id="authorName" class="authorName">Thomas H.Cormen</div>
                        <div id="authorRole" class="authorRole">作者</div>
                    </a>
                </li>
            </ul>
        </div>

        <!-- 收藏了这部书的人也收藏了-->
        <div id="content4" class="clearfix mt-4">
            <h2 id="togetherCollectionTitle" class="contentTitle">收藏了算法导论的人也收藏了 · · · · · · </h2>
            <ul id="togetherCollectionList" class="togetherCollectionUl">
                <li class="togetherCollectionLi m-2">
                    <a href="bookId!!!!!!!">
                        <img id="bookImg" class="bookImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/s1074361.jpg">
                        <div id="bookName" class="bookName">设计模式</div>
                    </a>
                </li>
            </ul>
        </div>

        <!-- 图书评论 -->
        <div id="content5" class="clearfix mt-4">
            <h2 id="commentListTitle" class="contentTitle">算法导论的评论 · · · · · · </h2>
            <div id="commentList" class="mt-3">
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="https://img2.doubanio.com/icon/u2612990-2.jpg">
                        <span class="ml-2 commentIcon">用户名</span>
                        <span class="ml-2">2021-04-16 10:13:38</span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        挺好的,就是学起来废头发
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> 325</btton>
                        <btton class="btn btn-sm btn-info" type="button"><i class="fas fa-reply"></i> 回复</btton>
                    </div>
                </div>
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="https://img2.doubanio.com/icon/u2612990-2.jpg">
                        <span class="ml-2 commentIcon">用户名</span>
                        <span class="ml-2">2021-04-16 10:13:38</span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        挺好的,就是学起来废头发
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> 325</btton>
                        <btton class="btn btn-sm btn-info" type="button"><i class="fas fa-reply"></i> 回复</btton>
                    </div>
                </div>
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="https://img2.doubanio.com/icon/u2612990-2.jpg">
                        <span class="ml-2 commentIcon">用户名</span>
                        <span class="ml-2">2021-04-16 10:13:38</span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        挺好的,就是学起来废头发
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> 325</btton>
                        <btton class="btn btn-sm btn-info" type="button"><i class="fas fa-reply"></i> 回复</btton>
                    </div>
                </div>
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="https://img2.doubanio.com/icon/u2612990-2.jpg">
                        <span class="ml-2 commentIcon">用户名</span>
                        <span class="ml-2">2021-04-16 10:13:38</span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        挺好的,就是学起来废头发
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> 325</btton>
                        <btton class="btn btn-sm btn-info" type="button"><i class="fas fa-reply"></i> 回复</btton>
                    </div>
                </div>
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="https://img2.doubanio.com/icon/u2612990-2.jpg">
                        <span class="ml-2 commentIcon">用户名</span>
                        <span class="ml-2">2021-04-16 10:13:38</span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        挺好的,就是学起来废头发
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> 325</btton>
                        <btton class="btn btn-sm btn-info" type="button"><i class="fas fa-reply"></i> 回复</btton>
                    </div>
                </div>
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="https://img2.doubanio.com/icon/u2612990-2.jpg">
                        <span class="ml-2 commentIcon">用户名</span>
                        <span class="ml-2">2021-04-16 10:13:38</span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        挺好的,就是学起来废头发
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> 325</btton>
                        <btton class="btn btn-sm btn-info" type="button"><i class="fas fa-reply"></i> 回复</btton>
                    </div>
                </div>
            </div>
        </div>



</body>
</html>
