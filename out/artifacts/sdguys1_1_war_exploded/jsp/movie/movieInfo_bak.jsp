<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>小人物</title>
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

        <!-- 电影标题 -->
        <h1 class="title mb-4">
            <span id="movieTitle">小人物 Nobody</span>
            <span style="color:#888" id="year">(2021)</span>
        </h1>
        <div id="content1" class="clearfix">
            <!-- 电影封面 和 电影信息 -->
            <div id="subContent1" class="float-left" style="width: 500px">
                <!-- 电影封面 -->
                <div id="movieCoverDiv" class="float-left" style="max-width:135px">
                    <img id="movieCover" src="https://gitee.com/a-shy-coder/blog-images/raw/master/p2633966702.webp"
                         class="cover">
                </div>
                <!-- 电影信息 -->
                <div id="movieInfo" class="float-left ml-3" style="max-width:333px">
                    <span class="greyText">导演: </span><span id="director"><a href="#">伊利亚·奈舒勒</a></span>
                    <br>
                    <span class="greyText">主演: </span><span class="actors">
                        <a href="#">鲍勃·奥登科克</a> /
                        <a href="#">鲍勃·奥登科克</a> /
                        <a href="#">鲍勃·奥登科克</a> /
                        <a href="#">鲍勃·奥登科克</a> /
                        <a href="#">鲍勃·奥登科克</a> /
                        <a href="#">鲍勃·奥登科克</a> /
                        <a href="#">鲍勃·奥登科克</a> /
                        <a href="#">鲍勃·奥登科克</a> /
                    </span>
                    <br>
                    <span class="greyText">类型: </span><span id="type">动作</span>
                    <br>
                    <span class="greyText">制片国家/地区: </span><span id="area">美国</span>
                    <br>
                    <span class="greyText">语言: </span><span id="language">英语</span>
                    <br>
                    <span class="greyText">上映日期: </span><span id="releaseDate">2021-03-26</span>
                    <br>
                    <span class="greyText">片长: </span><span id="length">92分钟</span>
                    <br>
                </div>
            </div>
            <!-- 电影评分与收藏 -->
            <div id="subContent2" class="float-left ml-4 borderLeft pl-2" style="width: 170px">
                <!-- 评分 -->
                <div class="pb-3">
                    <div style="color: #9b9b9b" class="mb-2">
                        绿豆芽评分
                    </div>
                    <div class="ratingText float-left mr-2">7.9</div>
                    <div id="rating" data-score="3.95"></div>
                    <script>
                        $(document).ready(function () {
                            $("#rating").raty({
                                path: 'img',
                                half: true,
                                readOnly: true,
                                halfShow: true,
                                noRatedMsg: "暂无评分",
                            });
                        })
                    </script>
                    <div class="rating_sum">
                        69927人评价
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
                                click:function(score){
                                    console.log(score);
                                }
                            });
                        })
                    </script>
                </div>
                <!-- 收藏 -->
                <div id="collection" class="pt-3 text-center borderTop">
                    <button class="btn btn-grey btn-sm" id="collectionBtn" type="button"><i class="far fa-star"></i> 收藏</button>
                </div>
            </div>
        </div>

        <!-- 电影简介 -->
        <div id="content2" class="clearfix mt-4">
            <h2 id="movieInfoTitle" class="contentTitle">小人物的剧情简介 · · · · · ·</h2>
            <div id="movieInfoContent">
                　　一天晚上，Hutch（鲍勃·奥登科克 Bob Odenkirk 饰）位于郊区的家中遭两名小偷闯入。为了避免暴力冲突，Hutch没有为自己或是家人反击。他的儿子Blake（盖奇·芒罗 Gage Munroe
                饰）对他感到很失望，他的老婆Becca（康妮·尼尔森 ConnieNielsen
                饰）似乎也因此更加疏远他。这起事件激发了Hutch心中压抑许久的情绪和本能，促使他走上残酷的道路，将揭露他黑暗的秘密和致命的能力。在拳头、枪弹和急速行驶的车阵中，Hutch必须从危险的敌人（阿列克谢·谢列布里亚科夫
                AlexeySerebryakov 饰）手中救出自己的家人，并确保别人不会再把他视作无名小卒。
            </div>
            <div id="side" class="float-right">
            </div>

        </div>

        <!-- 电影职员列表 -->
        <div id="content3" class="clearfix mt-4">
            <h2 id="movieActorTitle" class="contentTitle">小人物的演职员 · · · · · · </h2>
            <ul id="actorList" class="actorUl">
                <li class="actorLi m-2">
                    <a href="actorId!!!!!!!">
                        <img id="actorImg" class="actorImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p7204.webp">
                        <div id="actorName" class="actorName">鲍勃·奥登科克</div>
                        <div id="actorRole" class="actorRole">导演</div>
                    </a>
                </li>
                <li class="actorLi m-2">
                    <a href="actorId!!!!!!!">
                        <img id="actorImg" class="actorImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p7204.webp">
                        <div id="actorName" class="actorName">鲍勃·奥登科克</div>
                        <div id="actorRole" class="actorRole">主演</div>
                    </a>
                </li>
                <li class="actorLi m-2">
                    <a href="actorId!!!!!!!">
                        <img id="actorImg" class="actorImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p7204.webp">
                        <div id="actorName" class="actorName">鲍勃·奥登科克</div>
                        <div id="actorRole" class="actorRole">主演</div>
                    </a>
                </li>
                <li class="actorLi m-2">
                    <a href="actorId!!!!!!!">
                        <img id="actorImg" class="actorImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p7204.webp">
                        <div id="actorName" class="actorName">鲍勃·奥登科克</div>
                        <div id="actorRole" class="actorRole">主演</div>
                    </a>
                </li>
                <li class="actorLi m-2">
                    <a href="actorId!!!!!!!">
                        <img id="actorImg" class="actorImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p7204.webp">
                        <div id="actorName" class="actorName">鲍勃·奥登科克</div>
                        <div id="actorRole" class="actorRole">主演</div>
                    </a>
                </li>
                <li class="actorLi m-2">
                    <a href="actorId!!!!!!!">
                        <img id="actorImg" class="actorImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p7204.webp">
                        <div id="actorName" class="actorName">鲍勃·奥登科克</div>
                        <div id="actorRole" class="actorRole">主演</div>
                    </a>
                </li>

            </ul>
        </div>

        <!-- 收藏了这部电影的人也收藏了-->
        <div id="content4" class="clearfix mt-4">
            <h2 id="togetherCollectionTitle" class="contentTitle">收藏了这部电影的人也收藏了 · · · · · · </h2>
            <ul id="togetherCollectionList" class="togetherCollectionUl">
                <li class="togetherCollectionLi m-2">
                    <h3 class="releaseDate">2021</h3>
                    <a href="movieID!!!!!!!">
                        <img id="movieImg" class="movieImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p2551393832.webp">
                        <div id="movieName" class="movieName text-truncate">疾速追杀</div>
                    </a>
                    <div class="smallRatingText">8.0</div>

                </li>
                <li class="togetherCollectionLi m-2">
                    <a href="movieID!!!!!!!">
                        <img id="movieImg" class="movieImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p2551393832.webp">
                        <div id="movieName" class="movieName">疾速追杀</div>
                    </a>
                </li>
                <li class="togetherCollectionLi m-2">
                    <a href="movieID!!!!!!!">
                        <img id="movieImg" class="movieImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p2551393832.webp">
                        <div id="movieName" class="movieName">疾速追杀</div>
                    </a>
                </li>
                <li class="togetherCollectionLi m-2">
                    <a href="movieID!!!!!!!">
                        <img id="movieImg" class="movieImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p2551393832.webp">
                        <div id="movieName" class="movieName">疾速追杀</div>
                    </a>
                </li>
                <li class="togetherCollectionLi m-2">
                    <a href="movieID!!!!!!!">
                        <img id="movieImg" class="movieImg"
                             src="https://gitee.com/a-shy-coder/blog-images/raw/master/p2551393832.webp">
                        <div id="movieName" class="movieName">疾速追杀</div>
                    </a>
                </li>
            </ul>
        </div>

        <!-- 电影评论 -->
        <div id="content5" class="clearfix mt-4">
            <div >
                <h2 id="commentListTitle" class="contentTitle float-left" >小人物的评论 · · · · · · </h2>
                <btton id="commentButton" class="btn btn-sm btn-light-green m-0 ml-5" data-toggle="modal" data-target="#commentModal" ><i class="fas fa-comment-dots"></i>我要评论</btton>
            </div>
            <div id="commentList" class="mt-3">
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="https://img2.doubanio.com/icon/u2612990-2.jpg">
                        <span class="ml-2 commentIcon">用户名</span>
                        <span class="ml-2">2021-04-16 10:13:38</span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        别杀我的狗
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
                        别杀我的狗
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green"><i class="far fa-thumbs-up"></i> 325</btton>
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
                        别杀我的狗
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
                        别杀我的狗
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
                        别杀我的狗
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> 325</btton>
                        <btton class="btn btn-sm btn-info" type="button"><i class="fas fa-reply"></i> 回复</btton>
                    </div>
                </div>
            </div>
        </div>


        <!-- 评论框模态框 -->
        <div class="modal fade" id="commentModal" tabindex="-1" role="dialog" backdrop="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">评论</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group ">
                            <textarea class="form-control" id="submitcommentContent" rows="3" placeholder="写下您的评论"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <btton id="submitCommentButton" class="btn btn-sm btn-light-green " type="button" ><i class="fas fa-comment-dots"></i> 评论 </btton>
                    </div>
                </div>
            </div>
        </div>



</div>
</body>
</html>
