
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="home" value="/" />
<c:url var="defaultBookCoverUrl" value="/resources/img/book.jpg" />

<form class="ui form" id="searchForm">
	<div class="field">
		<div class="ui icon input">
			<input type="text" placeholder="Enter book's name, content..."
				name="content" id="main-content-search"> <i
				class="circular search link icon"></i>
		</div>
	</div>
	<div class="fields">
		<div class="seven wide field">
			<label>Book Category</label> 
			<div class="ui multiple search selection dropdown" id="book-category-input">
              <input type="hidden">
              <i class="dropdown icon"></i>
              <input type="text" class="search">
              <div class="default text">category...</div>
            </div>
		</div>
		<div class="four wide field">
			<label>Author</label>
			<div class="ui multiple search selection dropdown" id="book-author-input">
              <input type="hidden">
              <i class="dropdown icon"></i>
              <input type="text" class="search">
              <div class="default text">author...</div>
            </div>			
		</div>
		<div class="five wide field">
			<label>Date published</label> <input type="text"
				placeholder="date published" name="content">
		</div>
	</div>
	<div class="ui primary button">Find</div>
	<div class="ui reset button">Clear</div>
</form>


<script>
	var baseUrl = "${home}";
	var defaultBookCoverUrl = "${defaultBookCoverUrl}";
</script>

<script src="<c:url value="/resources/js/search.js" />"></script>