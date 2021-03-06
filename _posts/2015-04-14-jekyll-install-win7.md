---
layout: post
title: "install jekyll at win7"
keywords: ["jekyll", "win7"]
description: "win7安装jekyll server"
category: "jekyll"
tags: ["jekyll", "ruby"]
---
{% include JB/setup %}

在被jekyll深深的吸引之后，我决定开始折腾，籍以打发无聊的漫漫长夜。
最开始我想直接安装jekyll到阿里云服务器上，
考虑再三决定不再给我低端货色的阿里云服务器增加任何压力。流量也是要算钱的。
于是先放到github pages上面。
选了一套面容姣好的主题，几番挫折之后出现改动提交之后实际没有生效，
开始还以为是github缓存，后来收到一堆github pages build failed的信息。
于是准备在本地安装一套jekyll用于调试

## 一 下载所需的环境安装文件
首先在 http://rubyinstaller.org/downloads/ 上下载一个合适的rubyinstaller文件
还有 DEVELOPMENT KIT安装文件，对应的ruby选择相应的DevKit，比如我使用的是ruby2.2.1版本，所以选择了DevKit-mingw64-64-4.7.2-20130224-1432-sfx.exe 
都有对应的说明。

## 二 安装ruby环境
rubyinstaller是一个很方便的ruby windows环境安装工具，直接点击安装就行，注意选择：
![nam 示例]({{ IMAGE_PATH }}/content_step05fix.png)

即选择将ruby的运行目录添加到系统环境变量，如忘记勾选，需手动添加ruby安装的bin目录到系统path
命令行下输入ruby -v 检测是否安装成功：

```
C:\Users\Administrator>ruby -v
```

然后需要修改你的gem的sources为国内资源源，否则有可能出以下错误：
ERROR: While executing gem ... (Gem::RemoteFetcher::FetchError) Errno::ECONNRESET: Connection reset by peer - 

然后安装DevKit 双击安装文件安装到可意目录，然后切换至DevKit的安装目录

```
执行 ruby dk.rb init 生成config.yml配置文件
```


最后 ruby dk.rb install 安装 DevKit 到你ruby中。对于64位操作系统来说，可能会报错：‘Invalid configuration. Please fix ‘config.yml’ and rerun ‘ruby dk.rb install’`. 解决方案是将ruby目录的绝对路径写在config.yml中，如下：


```
# This configuration file contains the absolute path locations of all
# installed Rubies to be enhanced to work with the DevKit. This config
# file is generated by the 'ruby dk.rb init' step and may be modified
# before running the 'ruby dk.rb install' step. To include any installed
# Rubies that were not automagically discovered, simply add a line below
# the triple hyphens with the absolute path to the Ruby root directory.
#
# Example:
#
# ---
# - C:/ruby19trunk
# - C:/ruby192dev
#
---
- C:\Ruby22-x64
```

注意规则：在---下，以 - 开头，然后空一格，然后是写ruby的绝对路径。

然后再试 ruby dk.rb install.如下提示：

```
$ ruby dk.rb install
[INFO] Updating convenience notice gem override for 'C:/Ruby200-x64'
[INFO] Installing 'C:/Ruby200-x64/lib/ruby/site_ruby/devkit.rb'
```
那么就说明安装成功了，然后就安装jekyll吧


```
$ gem install jekyll
Temporarily enhancing PATH to include DevKit..
Building native extensions.  This could take a
Successfully installed fast-stemmer-1.0.2
Fetching: classifier-1.3.4.gem (100%)
Successfully installed classifier-1.3.4
Fetching: rb-fsevent-0.9.4.gem (100%)
......
```

检测是否安装成功：

```
$ jekyll -v
jekyll 2.5.3
```

如果安装成功，切换到你blog文件目录

```
jekyll serve
```
你会看到以下的build信息：
![run]({{ IMAGE_PATH }}/run.png)

这样就可以在本地build调试你的博客了


*主要参考：<http://www.cnblogs.com/BeginMan/p/3549241.html>*


