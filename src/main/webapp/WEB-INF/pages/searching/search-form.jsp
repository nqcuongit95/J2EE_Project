
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="ui form" id="searchForm">
	<div class="field">
		<div class="ui icon input">
			<input type="text" placeholder="Enter book's name, content..." 
				   name="content" id="main-content-search"> 
			<i class="circular search link icon"></i>
		</div>
	</div>
	<div class="fields">
		<div class="seven wide field">
			<label>Book Category</label> 
			<select name="skills" multiple=""
				class="ui fluid dropdown" id="book-category-input">
				<option value="">category</option>
				<option value="angular">Angular</option>
				<option value="css">CSS</option>
				<option value="design">Graphic Design</option>
			</select>
		</div>
		<div class="four wide field">
			<label>Author</label>
			<select name="skills" class="ui fluid search dropdown" 
					multiple="" id="book-author-input">
				<option value="">author</option>
			</select>
		</div>
		<div class="five wide field">
			<label>Date published</label> 
			<input type="text"
				placeholder="date published" name="content"> 
		</div>
	</div>
	<div class="ui primary button">Find</div>
	<div class="ui reset button">Clear</div>
</form>

<script src="<c:url value="/resources/js/search.js" />"></script>