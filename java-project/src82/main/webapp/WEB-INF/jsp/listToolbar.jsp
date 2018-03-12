<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<nav class="navbar navbar-light justify-content-between">
  <a href='form' class='btn btn-primary btn-sm'>추가</a>
  <form class="form-inline" action="list">
    <input name="words"
           class="form-control form-control-sm mr-sm-2" type="search" 
           placeholder="검색" aria-label="Search">
    <button class="btn btn-sm btn-outline-success my-2 my-sm-0" 
            type="submit">Search</button>
  </form>
</nav>

