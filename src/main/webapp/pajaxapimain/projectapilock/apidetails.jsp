<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>

    #requestDIVID {
        margin-top: 20px;
    }

    .form-inline {
        padding: 5px 0;
    }

    .one-line {
        display: inline;
        margin-right: 15px;
    }

    .form-inline label {
        padding-right: 10px;
        color: #0099b9
    }

</style>

<div class="clearfix"></div>
<div class="col-md-12" style="max-height: 700px; margin-top: -20px;">
    <div class="form-group top_01">
        <h3>参数名</h3>
        <div class="form-inline">
            <div class="one-line">
                <label>请求类型:</label><span class="btn btn-success" style="border-radius: 4px">${apiobj.formmethod}</span>
            </div>
            <div class="one-line">
                <label>接口地址:</label><span class="from-control">${apiobj.interfaceurl}</span>
            </div>

        </div>
        <div class="form-inline">
            <label>接口描述:</label><span class="dis_py"
                                      style="width: 630px !important; display: block">${apiobj.description}</span>
        </div>
    </div>


    <div id="requestDIVID">
        <h4>请求参数</h4>
        <c:forEach items="${paramListRquest}" var="obj" varStatus="stat">
        <div class="form-inline one-group">
            <input name="rquestParamUID" type="hidden" value="${obj.uid}"/>
            <ul>
                <li>
                    <div class="one-line">
                        <label>参数名:</label><span>${obj.paramname}</span>
                    </div>
                    <div class="one-line">
                        <label>参数类型:</label><span>${obj.paramtype}</span>
                    </div>
                    <div class="one-line">
                        <label>是否必填:</label><span <c:if test="${obj.paramrequired=='是'}">style="color: red" </c:if> >${obj.paramrequired}</span>
                    </div>
                    <div class="one-line">
                        <label>备注:</label><span>${obj.parambeizhu}</span>
                    </div>
                </li>

            </ul>
                <%--<div class="form-group">
                      <label>参数名:${obj.paramname}</label>
                  </div>
                  <div class="form-group">
                      <label>参数类型:${obj.paramtype}</label>
                  </div>
                  <div class="form-group">
                      <label>是否必填:${obj.paramrequired}</label>
                  </div>
                  <div class="form-group">
                      <label>备注:${obj.parambeizhu}</label>
                  </div>
              </div>--%>
            </c:forEach>
        </div>


        <div id="responseDIVID">
            <%--一行三列结束--%>
            <h4>返回参数</h4>


            <c:forEach items="${paramListResponse}" var="obj" varStatus="stat">
                <ul>
                    <li>
                        <div class="one-line">
                            <label>参数名:</label><span>${obj.paramname}</span>
                        </div>
                        <div class="one-line">
                            <label>参数类型:</label><span>${obj.paramtype}</span>
                        </div>
                        <div class="one-line">

                            <label>是否必填:</label><span  <c:if test="${obj.paramrequired=='是'}">style="color: red" </c:if> >${obj.paramrequired}</span>
                        </div>
                        <div class="one-line">
                            <label>备注:</label><span>${obj.parambeizhu}</span>
                        </div>
                    </li>
                </ul>
                <%--<div class="form-inline one-group">
                    <input name="rquestParamUID" type="hidden" value="${obj.uid}"/>
                    <div class="form-group">
                        <label>参数名:${obj.paramname}</label>
                    </div>
                    <div class="form-group">
                        <label>参数类型:${obj.paramtype}</label>
                    </div>
                    <div class="form-group">
                        <label>是否必填:${obj.paramrequired}</label>
                    </div>
                    <div class="form-group">
                        <label>备注:${obj.parambeizhu}</label>
                    </div>
                </div>--%>
            </c:forEach>
        </div>
        <%--一行三列结束--%>

        </form>
    </div>
    <script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
    <script language="javascript" type="text/javascript" src="assets/js/apimain/projectapilock/apidetails.js"></script>

