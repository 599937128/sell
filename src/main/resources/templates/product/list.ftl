<html>
<#include "../common/header.ftl">
    <body>
    <div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>商品id</th>
                                <th>名称</th>
                                <th>图片</th>
                                <th>单价</th>
                                <th>库存</th>
                                <th>描述</th>
                                <th>类目</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list productInfoPage.content as ProductInfo>
                            <tr>
                                <td>${ProductInfo.productId}</td>
                                <td>${ProductInfo.productName}</td>
                                <td><img height="100" width="100" src="${ProductInfo.productIcon}"></td>
                                <td>${ProductInfo.productPrice}</td>
                                <td>${ProductInfo.productStock}</td>
                                <td>${ProductInfo.productDescription}</td>
                                <td>${ProductInfo.categoryType}</td>
                                <td>${ProductInfo.createTime}</td>
                                <td>${ProductInfo.updateTime}</td>
                                <td><a href="http://127.0.0.1:8080/sell/seller/product/index?productId=${ProductInfo.productId}">修改</a></td>
                                <td>
                                    <#if ProductInfo.getProductStatusEnum().message == "在架">
                                        <a href="http://127.0.0.1:8080/sell/seller/product/off_sale?productId=${ProductInfo.productId}">下架</a>
                                        <#else>
                                        <a href="http://127.0.0.1:8080/sell/seller/product/on_sale?productId=${ProductInfo.productId}">上架</a>
                                    </#if>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                        <#--分页-->
                        <div class="col-md-12 column">
                            <ul class="pagination pull-right">
                                <#if currentPage lte 1>
                                    <li class="disabled"><a href="#">上一页</a></li>
                                <#else>
                                     <li>
                                         <a href="http://127.0.0.1:8080/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a>
                                     </li>
                                </#if>
                                    <#list 1..productInfoPage.getTotalPages() as index>
                                        <#if currentPage == index>
                                            <li class="disabled"><a href="#">${index}</a></li>
                                            <#else>
                                                 <li><a href="http://127.0.0.1:8080/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                        </#if>
                                    </#list>

                                <#if currentPage gte productInfoPage.getTotalPages()>
                                     <li class="disabled"><a href="#">下一页</a></li>
                                <#else>
                                 <li>
                                     <a href="http://127.0.0.1:8080/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a>
                                 </li>
                                </#if>
                            </ul>
                         </div>
                    </div>
                 </div>
                </div>
            </div>
        </div>
    </body>
</html>

