(function($){
	/*
	 * 效果:点击缩略图显示大图
	 * 传入对象参数:movieThumbnail缩略图位置所在的DIV,movieDetail:详细图所在的IMG
	 * thumbnailImgLocation:缩略图文件夹位置,detailImgLocation:详细图文件夹位置,movieButton:"#movieButton"
	 */
	$.fn.movieSlice = function(options){
		var settings = $.extend({
			movieThumbnail:"#movieThumbnail",
			movieDetail:"#movieDetail",
			thumbnailImgLocation:"img-thumbnail",
			detailImgLocation:"img-big",
			movieButton:"#movieButton"
		},options||{});
		var thumbnails = this.find(".thumPic");
		thumbnails.each(function(n){
			if(n==0){
				$(settings.movieDetail).attr("src",$(this).attr("src").replace(settings.thumbnailImgLocation,settings.detailImgLocation));
			}
			$(this).data("p-index",n);
		})
		var curIndex = 0;
		thumbnails.on("click",function(){
			curIndex = $(this).data("p-index");
			showPhoto();
		});
		function showPhoto(){
			if(curIndex < 0){
				curIndex = 0;
			}else if(curIndex > thumbnails.length-1){
				curIndex = thumbnails.length-1;
			}
			$(settings.movieDetail).attr("src",$(thumbnails[curIndex]).attr("src").replace(settings.thumbnailImgLocation,settings.detailImgLocation));
		}
		var movieButtons = $(settings.movieButton);
		movieButtons.find("input[name='first']").click(function(){
			curIndex = 0;
			showPhoto();
		});
		movieButtons.find("input[name='prev']").click(function(){
			curIndex--;
			showPhoto();
		});
		movieButtons.find("input[name='next']").click(function(){
			curIndex++;
			showPhoto();
		});
		movieButtons.find("input[name='last']").click(function(){
			curIndex = thumbnails.length-1;
			showPhoto();
		});
		this.find(settings.movieDetail).click(function(){
			curIndex++;
			showPhoto();
		});
		return this;
	}
})(jQuery);
