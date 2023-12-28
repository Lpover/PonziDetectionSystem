<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"></meta>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
    <style>
        .main {
            background: url(https://digital-content.obs.cn-east-3.myhuaweicloud.com/evidence/dd47.png) no-repeat;
            background-size: 551px 839px;
            height: 839px;
            width: 551px;
            position: relative;
        }

        .title {
            padding-top: 180px;
            font-size: 30px;
            font-weight: 600;
            padding-left: 150px;
        }

        .content {
            padding-top: 30px;
            padding-left: 60px;
        }

        .content-row {
            margin-top: 25px;
            font-size: 16px;
        }

        .content-row-label {
            font-weight: 600;
            font-size: 18px;
            width: 400px;
            overflow-wrap: break-word;
        }

    </style>
</head>

<body>
    <div id="main" class="main">
        <div id="title" class="title">电子数据保全证书</div>
        <div id="content" class="content">
            <div id="content-row" class="content-row">
                <div id="content-row-label" class="content-row-label">保全人：${who}</div>
<#--                <div id="content-row-user" class="content-row-text"></div>-->
            </div>
            <div id="content-row" class="content-row">
                <div id="content-row-label" class="content-row-label">保全平台：${platform}</div>
<#--                <div id="content-row-platform" class="content-row-text"></div>-->
            </div>
            <div id="content-row" class="content-row">
                <div id="content-row-label" class="content-row-label">保全类型：${type}</div>
<#--                <div id="content-row-type" class="content-row-text"></div>-->
            </div>
            <div id="content-row" class="content-row">
                <div id="content-row-label" class="content-row-label">保全网址：${url}</div>
<#--                <div id="content-row-url" class="content-row-text"></div>-->
            </div>
            <div id="content-row" class="content-row">
                <div id="content-row-label" class="content-row-label">区块链哈希值：${txhash}</div>
<#--                <div id="content-row-chain-hash" class="content-row-text"></div>-->
            </div>
            <div id="content-row" class="content-row">
                <div id="content-row-label" class="content-row-label">区块链：${chain}</div>
<#--                <div id="content-row-chain" class="content-row-text"></div>-->
            </div>
            <div id="content-row" class="content-row">
                <div id="content-row-label" class="content-row-label">上链时间：${timestamp?string('yyyy.MM.dd HH:mm:ss')}</div>
<#--                <div id="content-row-chain-time" class="content-row-text"></div>-->
            </div>
            <div id="content-row" class="content-row">
                <div id="content-row-label" class="content-row-label">证据包哈希：${packagehash}</div>
            </div>
        </div>
    </div>
</body>

</html>