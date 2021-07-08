# 该镜像需要依赖的基础镜像
FROM java:8
# 将当前目录下的jar包复制到docker容器的/目录下
ADD *.jar /fzyjpa.jar
# 运行过程中创建一个mall-tiny-docker-file.jar文件
RUN bash -c 'touch /fzyjpa.jar'
# 声明服务运行在8089端口
EXPOSE 8080
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","/fzyjpa.jar"]
# 指定维护者的名字
MAINTAINER fzy

#打包命令，dockerfile和jar放在同一目录下
#docker build -t ${jar_name}:1.0 .