<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jQuery. Disappear</title>

<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>

<script type="text/javascript">
$(document).ready(function(){
						   
	$(".pane .delete").click(function(){
		$(this).parents(".pane").animate({ opacity: 'hide' }, "slow");
	});

});
</script>

<style type="text/css">
body {
	margin: 10px auto;
	width: 470px;
}
h3 {
	margin: 0;
	padding: 0 0 .3em;
}
p {
	margin: 0;
	padding: 0 0 .5em;
}
.pane {
	background: #edf5e1;
	padding: 10px 20px 10px;
	position: relative;
	border-top: solid 2px #c4df9b;
}
.pane .delete {
	position: absolute;
	top: 10px;
	right: 10px;
	cursor: pointer;
}
</style>
</head>

<body>
<div class="pane">
	<h3>Sample heading</h3>
	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi malesuada, ante at feugiat tincidunt, enim massa gravida metus, commodo lacinia massa diam vel eros. Proin eget urna. Nunc fringilla neque vitae odio. Vivamus vitae ligula.</p>
	<img src="images/btn-delete.gif" alt="delete" class="delete" />
</div>
<div class="pane">
	<h3>Sample heading</h3>
	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi malesuada, ante at feugiat tincidunt, enim massa gravida metus, commodo lacinia massa diam vel eros. Proin eget urna. Nunc fringilla neque vitae odio. Vivamus vitae ligula.</p>
	<img src="images/btn-delete.gif" alt="delete" class="delete" />
</div>
<div class="pane">
	<h3>Sample heading</h3>
	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi malesuada, ante at feugiat tincidunt, enim massa gravida metus, commodo lacinia massa diam vel eros. Proin eget urna. Nunc fringilla neque vitae odio. Vivamus vitae ligula.</p>
	<img src="images/btn-delete.gif" alt="delete" class="delete" />
</div>
<div class="pane">
	<h3>Sample heading</h3>
	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi malesuada, ante at feugiat tincidunt, enim massa gravida metus, commodo lacinia massa diam vel eros. Proin eget urna. Nunc fringilla neque vitae odio. Vivamus vitae ligula.</p>
	<img src="images/btn-delete.gif" alt="delete" class="delete" />
</div>
<div class="pane">
	<h3>Sample heading</h3>
	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi malesuada, ante at feugiat tincidunt, enim massa gravida metus, commodo lacinia massa diam vel eros. Proin eget urna. Nunc fringilla neque vitae odio. Vivamus vitae ligula.</p>
	<img src="images/btn-delete.gif" alt="delete" class="delete" />
</div>
</body>
</html>
