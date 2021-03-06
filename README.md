# Curiosity-Inspirement
hackxfdu2017 project 
Curiosity Inspirement 帮助人们释放好奇的天性。让AI读懂你随手的涂鸦及非专业的语言表达，让你对你所好奇的事物有最直观的认知

## 详情描述
* Part I   通过手绘[RNN辅助]草图，口头描述输入对象.     【人为处理对象提取特征，完成数据收集】
* Part II   利用CNN图像识别，云知声语音识别特征得到关键字.     【机器学习将特征与数据库比对，完成数据处理】    
* Part III  输出三维模型及相关wiki资料.【知识（数据）获取】    
  * 0.随时满足大多数人对新鲜事物的好奇心，并激发灵感
  * 1.工程师快速调取图纸。
  * 2.装置艺术家学习及灵感记录
  * 3.新型搜索引擎式学习


## 图片展示
![](http://oo8jzybo8.bkt.clouddn.com/sword111111111.png)

## 创意来源
* 《钢铁侠》中Tony Stark通过语音调取父亲设计的世博园图纸
* "quick draw"+象形文字 对事物特征的记录
* 随着信息爆炸，满足求知欲的成本日渐增加。希望利用人工智能技术把成本降到最低，重新迎来一个可以用原始方式（图像或者语音记录事物特征）求知的时代。
* 希望建立新“物联网”体系，物体以数据形式存在于网络中，可通过迷你工厂（终端）调取。
（通过互联网可以搜索，并通过3d打印得到物体）

## 核心技术说明
![](http://oo8jzybo8.bkt.clouddn.com/kuangjia.png)

### 1.Autodesk Forge 平台
Autodesk Forge是集开发人员社区、开发技术PaaS平台以及投资基金为一体的体系，引领行业的创新，并能推进到3D 打印、物联网等更为广阔的应用领域。

Forge的技术包括设计，可视化，协作，制造，使用五个模块。每个模块中会有多样的服务。而实际的业务应用或是多个服务的集成。

其中， View & Data是Autodesk Forge平台开发的技术之一，它基于最流行的HTML5/WebGL技术，降低了对模型预处理难度，只需要浏览器就能分享，查看模型，进行协作。随时，随地，任何设备。而且通过流式加载，漫游优化以支持超大模型。此技术涵盖CAD行业几乎所有三维数据格式，真正打通了三维数据集成的瓶颈。除了三维模型的浏览，漫游，测量，丰富剖切功能，View & Data 也是紧密围绕着数据，提供模型结构树以及对象的属性，让模型的信息能够以最简便的方式分享和查看，高效实施模型管理，而不仅只是简单的几何图形展示。View & Data也提供了API，由两部分组成，原始模型格式转换为浏览器格式以REST的方式调用；浏览器端提供基于JavaScript的API，可以结合业务流程，对模型做细节管理，深度集成，对接报价，运维，物联网等。   

该项目借助于 Autodesk Forge平台和其所含的View & Data技术，解决了各种模型格式化，模型轻量化，对超大模型的综合管理，客户端（甚至0插件）轻量化及使任何终端都支持的问题。

### 2.Web VR
基于Web的虚拟现实技术(Virtual Reality,简称VR)是指借助计算机及最新传感器技术创造的一种崭新的人机交互手段。虚拟现实技术综合了计算机图形技术、计算机仿真技术、传感器技术、显示技术等多种科学技术，它在多维信息空间上利用网络创建一个虚拟信息环境，能使用户具有身临其境的沉浸感，具有与环境完善的交互作用能力，并有助于启发构思。因而，沉浸 - 交互 - 构想是 VR 环境系统的三个基本特性。其核心价值是能将视听体验带到一个新高度。
本项目借助于该技术提供了更逼真的、具有交互性的三维可视化环境,使用户更方便于对产品的观察和评估。

### 3.循环神经网络(RNN)

用神经网络算法实现简体图形的识别。循环神经网络是一种具有反馈结构的神经网络，其输出不但与当前输入和网络的权值有关，也与之前网络输入有关。RNN通过添加跨越时间点的自连接隐藏层，对时间进行建模，可以更好的捕获长期依赖。

### 4.Django
Django是一个由Python语言编写的开放源代码的Web应用框架，能快速开发且遵循MVC（Django更关注模（Model）、模板（Template）和视图（Views），也称为MTV模式）设计模式，能使开发复杂的、数据库驱动的网站变得简单。本项目用Python语言在Django的Web应用框架中控制简体图形的识别和声音信息的识别。

### 5.Node.js
Node.js实际就是运行在事件驱动I/O服务端的JavaScript，可方便的搭建速度快、易于扩展的网络应用，适合在分布式设备上运行数据密集型的实时应用，用其开发一些快速移动的Web框架。本项目中Node.js构建稳定运行的Web VR服务框架，保证系统的的稳定运行。