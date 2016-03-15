<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main page</title>
        <script src="lib/jquery-1.12.1.min.js"></script>
        <script src="lib/index.js"></script>
    </head>
    <body>
        <!-- Progress bar area -->
        <div id="progressBar" style="display:none">
            <img src="images/progress.gif"/>
        </div>
        <!-- Buttons area -->
        <div>
            <input id="clearCache" type="button" value="Clear cache"/>
            <input id="fillCache" type="button" value="Fill cache"/>
            <input id="checkCache" type="button" value="Check cache"/>
            <input id="calcTotal" type="button" value="Calc total"/>
        </div>
        <!-- Status area -->
        <div id="commonStatus">
            <span id="resultTitle">Status:</span>
            <span id="resultCode"></span>
            <span id="resultText"></span>
        </div>
        <!-- Result area -->
        <div id="reasultsArea">
            <span>Total sum for all nodes is:</span>
            <span id="resultField"></span>
        </div>
    </body>
</html>
