<#import "parts/common.ftlh" as c>

<@c.page>
<div style="margin-top: 50px;">
    <div>
        <form action="/logout" method="post">
            <input type="submit" value="Покинуть" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>
    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Введите ФИО"/>
            <input type="text" name="groupp" placeholder="Введите номер группы">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список студентов</div>
    <form method="post" action="filter">
        <input type="text" name="filter">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Найти</button>
    </form>
    <#list students as student>
        <div>
            <b>${student.getGroup()}</b>
            <span>${student.getName()}</span>
        </div>
    <#else >
        Список пуст
    </#list>
</@c.page>
