$(document).ready(function() {
	$('#book-crud-form').form({
		inline : true,
		on : 'blur',
		fields : {
			maSach : {
				identifier : 'maSach',
				rules : [ {
					type : 'maxLength[12]',
					prompt : 'Max length of BookID is 12'
				}, {
					type : 'empty',
					prompt : 'Please enter BookID'
				} ]
			},
			ten : {
				identifier : 'ten',
				rules : [ {
					type : 'maxLength[500]',
					prompt : 'Max length of Book name is 500'
				}, {
					type : 'empty',
					prompt : 'Please enter Book name'
				} ]
			},
			tacGia : {
				identifier : 'tacGia',
				rules : [ {
					type : 'maxLength[2000]',
					prompt : 'Max length of Authors is 2000'
				} ]
			},
			isbn : {
				identifier : 'isbn',
				rules : [ {
					type : 'maxLength[2000]',
					prompt : 'Max length of ISBN is 2000'
				} ]
			},
			tomTat : {
				identifier : 'tomTat',
				rules : [ {
					type : 'maxLength[1000]',
					prompt : 'Max length of Description is 1000'
				} ]
			},
			ghiChu : {
				identifier : 'ghiChu',
				rules : [ {
					type : 'maxLength[2000]',
					prompt : 'Max length of Note is 2000'
				} ]
			},
		}
	});
});
