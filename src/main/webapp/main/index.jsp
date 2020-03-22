<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DOGIVER</title>
    <link rel="stylesheet" href="../css/style.css" />
    <link
      rel="stylesheet"
      type="text/css"
      href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"
    />
    <link
      rel="stylesheet"
      href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean"
      rel="stylesheet"
    />
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-3.4.1.min.js"
    ></script>
    <script
      type="text/javascript"
      src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"
    ></script>
    <script src="../js/main.js"></script>
  </head>
  <body>
    <div id="headerDiv"></div>
    <div class="wrap">
      <div class="slider">
        <div><img src="../image/slide-image-1.jpg" alt="slide1" /></div>
        <div><img src="../image/slide-image-4.jpg" alt="slide2" /></div>
        <div><img src="../image/slide-image-5.jpg" alt="slide3" /></div>
      </div>
      <div class="card-box">
        <div></div>
        <div>
          <div></div>
          <div></div>
          <div></div>
        </div>
      </div>
    </div>
    <div id="footerDiv"></div>
  </body>
  <script>
    $(".slider").slick({
      autoplay: true,
      autoplaySpeed: 2000,
      dots: true
    });
  </script>
</html>