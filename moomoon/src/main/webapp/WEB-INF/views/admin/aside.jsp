<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>moomoon</title>
<link rel="stylesheet" href="<c:url value="/resources/css/sidemenu.css" />">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&family=Raleway:wght@300&display=swap" rel="stylesheet">
</head>
<body>
	<!-- The sidebar -->
	<div class="sidebar">
	  <a class="active" href="#">Questioner</a>
	  <a href="#news">CodeCamp</a>
	  <a href="#contact">Modify</a>
	</div>
	
	<!-- Page content -->
	<div class="content">
	  	 <div>
		  <div class="input_area">
		   <label for="userId">자신있는 언어 및 기술을 태그하세요.</label>
		   <input hidden="hidden" />
		   <input type="text" id="language" name="language" placeholder="자바" required="required" />
		   <button class="langAdd" id="langAdd"> + </button>      
		  </div>
		  
		   <ul class="langul">
		   </ul>
		  <button type="submit" id="signup_btn" name="signup_btn">리뷰어 등록하기</button>
		  
		 </div>   
	</div>

</body>
<script type="text/javascript">
	
	var XMLRequestObject = {
		    sendPost : function (url, query,successCallback) {
		        const initXML = this.initializeRequestObject(url);
		        initXML.onreadystatechange = function () {
		            if (initXML.readyState == XMLHttpRequest.DONE) {
		                if (initXML.status == 200) {
		                    successCallback(initXML);
		                }
		            }
		        }
		        initXML.send(query);
		    },
		    initializeRequestObject : function (url) {
		        const XML = new XMLHttpRequest();
		        XML.open("POST", url,true);
		        XML.withCredentials = true;

		        return XML;
		    }
		};
		
	

		var langAry = [];
        document.getElementById("langAdd").addEventListener("click", () => {
        	var inputLang = document.getElementById("language");
        	var ul = document.getElementsByClassName("langul");
			var liAdd = document.createElement("li");
			liAdd.textContent = "#"+inputLang.value;
			liAdd.name=inputLang.value;
			liAdd.addEventListener("click", () => {
				ul[0].removeChild(liAdd);
			});
        	ul[0].appendChild(liAdd);

        	inputLang.value="";
        		
        	
		});
		
        document.getElementById("signup_btn").addEventListener("click", () => {

			var li = document.getElementsByClassName("langul")[0].querySelectorAll("li");
			for(var i=0;i<li.length;i++){
				langAry.push(li[i].name);
			}
			console.log(langAry);
			XMLRequestObject.sendPost("postAjax.do?"+"data="+langAry,null,(res) => {
				var data=res.responseText;
				console.log(data);
			});
		});

        
    </script>
</html>