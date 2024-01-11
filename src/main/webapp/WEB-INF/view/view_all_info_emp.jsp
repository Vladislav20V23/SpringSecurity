<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
    <html>

        <BODY>


            <H3>База данных предприятия "ТехРос" </H3>
            <br> <br>

            <security:authorize access="hasRole('HR')">         // область видимости для определенной роли
            <input type="button" value="Зарплата сотрудников" onclick="window.location.href='he_info'">

            </security:authorize>



            <security:authorize access="hasRole('DIRECTOR')">
            <input type="button" value="Производительность" onclick="window.location.href='director_info'">

            </security:authorize>

            <br><br>

            <p>Список лучшиъ работников</p>

            <ol>
                <li> Vlad </li>
                <li> Andrey </li>
                <li> Ira </li>

            </ol>

        </BODY>

    </html>