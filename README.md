[![Java CI](https://github.com/org-fullscore-intercom/ServiceForIntercom/actions/workflows/maven.yml/badge.svg)](https://github.com/org-fullscore-intercom/ServiceForIntercom/actions/workflows/maven.yml)
# ServiceForIntercom
the backport of the application
## 1.1 单元测试

项目由Java编写，所以这里采用了JUnit进行单元测试。单元测试是针对单个Java方法所写的测试

下图是在项目中编写的单元测试

![image-20230427162722642](https://cdn.jsdelivr.net/gh/Toreme/BlogImage@main/img/image-20230427162722642.png)

## 1.2 代码覆盖检测

覆盖率检测工具使用JaCoCo。JaCoCo是专门为Java提供的用于检测测试覆盖率的工具，英文全称为Java Code Coverage

首先在项目的pom.xml添加相关配置

![image-20230427162553564](../AppData/Roaming/Typora/typora-user-images/image-20230427162553564.png)

然后运行maven test，在target中生成了jacoco报告

![image-20230427162646607](https://cdn.jsdelivr.net/gh/Toreme/BlogImage@main/img/image-20230427162646607.png)

![image-20230427162506933](https://cdn.jsdelivr.net/gh/Toreme/BlogImage@main/img/image-20230427162506933.png)

## 1.3 GitHub Action 持续集成

使用 Maven 构建和测试 Java

创建工作流：

![image-20230427153625554](https://cdn.jsdelivr.net/gh/Toreme/BlogImage@main/img/image-20230427153625554.png)

1. `checkout` 步骤在运行器上下载存储库的副本。
2. `setup-java` 步骤配置 Oracle (Java) 17 JDK x64。
3. “使用 Maven 构建”步骤以非交互模式运行 Maven `package` 目标，以确保生成代码、通过测试以及可创建包。

启动持续集成

![image-20230427154028054](https://cdn.jsdelivr.net/gh/Toreme/BlogImage@main/img/image-20230427154028054.png)

用户push代码时自动运行单元测试，并在README中显示自动测试的结果

