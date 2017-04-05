<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
    .m_r {
        margin-right: 15px;
    }

    .one-group {
        margin-top: 20px !important;
    }

    .one-group .from-group {
        margin-right: 15px;
    }

    label {
        width: 80px;
        text-align: right
    }

    .form-control {
        width: 167px !important;
    }

    .tta {
        width: 423px !important;
    }

</style>

<div class="clearfix"></div>
<div class="col-md-12" style="max-height: 700px; margin-top: -20px;">
    <div class="col-md-12" style="position: fixed;background: #fff; padding: 15px;">
        <button class="btn btn-primary" id="subBT" type="button">保存</button>
    </div>
    <form id="subform" class="form-group" style="margin-top: 65px; padding-bottom: 40px" id="subForm" method="post"
          action="apiHandler/saveApiParams">
        <input name="apiID" type="hidden" value="${param.apiID}"/>
        <input name="projectid" type="hidden" value="${param.projectid}"/>
        <div class="form-group top_01">
            <h3>参数名</h3>
            <div class="form-inline">
                <label>请求类型</label>
                <input type="hidden" value="${apiobj.formmethod}"/>
                <select class="form-control" name="formMethod" setVal="${apiobj.formmethod}">
                    <option selected value="post">post</option>
                    <option value="get">get</option>
                </select>
                <label>接口地址</label>
                <input name="interfaceURL" type="text" required errInfo="接口地址不能为空！" class="form-control"
                       value="${apiobj.interfaceurl}"
                       placeholder="接口地址">
            </div>
        </div>
        <div class="form-inline">
            <label>接口描述</label>
            <textarea class="form-control tta" rows="3" cols="100" name="description">${apiobj.description}</textarea>

        </div>

        <div id="requestDIVID">
            <h4>请求参数</h4>

            <c:if test="${paramListRquest==null}">
                <%--一行三列开始--%>
                <div class="form-inline one-group">
                    <input name="rquestParamUID" type="hidden" value="-1"/>
                    <div class="form-group">
                        <label>参数名</label>
                        <input name="rquestParam" type="text" class="form-control" placeholder="请求参数名" required
                               value="${obj.paramname}"
                               errInfo="请求参数名不能为空！">
                    </div>
                    <div class="form-group">
                        <label>参数类型</label>
                        <select class="form-control" name="rquestParamType">
                            <option selected>string</option>
                            <option>number</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>是否必填</label>
                        <select class="form-control" name="rquestParamrequired" setVal="${obj.paramrequired}">
                            <option value="是">是</option>
                            <option value="否" selected>否</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>备注</label>
                        <input name="rquestParamBeizhu" type="text" class="form-control" placeholder="请求参数备注"
                               value="${obj.parambeizhu}"
                               required
                               errInfo="请求参数备注不能为空！">
                    </div>
                        <%--添加按钮--%>
                    <div class="form-group">
                        <button id="addRequestBTID_" class="btn btn-success">添加</button>
                    </div>
                        <%--添加按钮结束--%>
                </div>
            </c:if>

            <c:forEach items="${paramListRquest}" var="obj" varStatus="stat">
                <%--一行三列开始--%>
                <div class="form-inline one-group">
                    <input name="rquestParamUID" type="hidden" value="${obj.uid}"/>
                    <div class="form-group">
                        <label>参数名</label>
                        <input name="rquestParam" type="text" class="form-control" placeholder="请求参数名" required
                               value="${obj.paramname}"
                               errInfo="请求参数名不能为空！">
                    </div>
                    <div class="form-group">
                        <label>参数类型</label>
                        <select class="form-control" name="rquestParamType" setVal="${obj.paramtype}">
                            <option selected>string</option>
                            <option>number</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>是否必填</label>
                        <select class="form-control" name="rquestParamrequired" setVal="${obj.paramrequired}">
                            <option value="是">是</option>
                            <option value="否" selected>否</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>备注</label>
                        <input name="rquestParamBeizhu" type="text" class="form-control" placeholder="请求参数备注"
                               value="${obj.parambeizhu}"
                               required
                               errInfo="请求参数备注不能为空！">
                    </div>
                        <%--添加按钮--%>
                    <div class="form-group">
                        <c:if test="${stat.last}">
                            <button id="addRequestBTID_${obj.uid}" class="btn btn-success">添加</button>
                        </c:if>
                        <!--不是最后一个-->
                        <c:if test="${stat.count!=fn:length(paramListRquest)}">
                            <button id="delRequestBTID_${obj.uid}" class="btn btn-success">删除</button>
                        </c:if>
                    </div>
                        <%--添加按钮结束--%>
                </div>

            </c:forEach>
        </div>


        <div id="responseDIVID">
            <%--一行三列结束--%>
            <h4>返回参数</h4>

            <c:if test="${paramListResponse==null}">
                <%--一行三列开始--%>
                <div class="form-inline one-group">
                    <input name="responseParamUID" type="hidden" value="-1"/>
                    <div class="form-group">
                        <label>参数名</label>
                        <input name="responseParam" type="text" class="form-control" placeholder="返回参数名" required
                               value="${obj.paramname}"
                               errInfo="返回参数名不能为空！">
                    </div>
                    <div class="form-group">
                        <label>参数类型</label>
                        <select class="form-control" name="responseParamType">
                            <option selected>string</option>
                            <option>number</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>是否必填</label>
                        <select class="form-control" name="responseParamrequired" setVal="${obj.paramrequired}">
                            <option value="是">是</option>
                            <option value="否" selected>否</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>备注</label>
                        <input name="responseParamBeizhu" type="text" class="form-control" placeholder="返回参数备注"
                               value="${obj.parambeizhu}"
                               required
                               errInfo="返回参数备注不能为空！">
                    </div>
                        <%--添加按钮--%>
                    <div class="form-group">
                        <button id="addResponseBTID_" class="btn btn-success">添加</button>
                    </div>
                        <%--添加按钮结束--%>
                </div>
            </c:if>
            <c:forEach items="${paramListResponse}" var="obj" varStatus="stat">


                <%--一行三列开始--%>
                <div class="form-inline one-group">
                    <input name="responseParamUID" type="hidden" value="${obj.uid}"/>
                    <div class="form-group">
                        <label>参数名</label>
                        <input name="responseParam" type="text" class="form-control" placeholder="返回参数名" required
                               value="${obj.paramname}"
                               errInfo="返回参数名不能为空！">
                    </div>
                    <div class="form-group">
                        <label>参数类型</label>
                        <select class="form-control" name="responseParamType" setVal="${obj.paramtype}">
                            <option selected>string</option>
                            <option>number</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>是否必填</label>
                        <select class="form-control" name="responseParamrequired" setVal="${obj.paramrequired}">
                            <option value="是">是</option>
                            <option value="否" selected>否</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>备注</label>
                        <input name="responseParamBeizhu" type="text" class="form-control" placeholder="返回参数备注"
                               value="${obj.parambeizhu}"
                               required
                               errInfo="返回参数备注不能为空！">
                    </div>
                        <%--添加按钮--%>
                    <div class="form-group">
                        <c:if test="${stat.last}">
                            <button id="addResponseBTID_${obj.uid}" class="btn btn-success">添加</button>
                        </c:if>
                        <c:if test="${stat.count!=fn:length(paramListResponse)}">
                            <button id="delResponseBTID_${obj.uid}" class="btn btn-success">删除</button>
                        </c:if>
                    </div>
                        <%--添加按钮结束--%>
                </div>

            </c:forEach>
        </div>
        <%--一行三列结束--%>

    </form>
</div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/apimain/projectapi/addapi.js"></script>

