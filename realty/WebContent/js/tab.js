$(document).ready(
        function(){
            $("li").each(function(index){
                $(this).click(function(){
                    
                        $(".content_area").removeClass("content_area");
                        $(".listli").removeClass("listli");
                        $("#tab_area *").eq(index).addClass("content_area");
                        $("li").eq(index).addClass("listli");
                    
                });
            });
        }
);