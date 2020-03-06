# Automated-Testing

## Student: Tran Trong Tien 3630201/70101
## Requirements: 
1. Linux base system
2. Chrome browser
3. Chrome web driver in directory /bin/usr
4. Maven

## Install ChromeDriver:
```
$ wget https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip
$ unzip chromedriver_linux64.zip
$ sudo mv chromedriver /usr/bin/chromedriver
$ sudo chown root:root /usr/bin/chromedriver
$ sudo chmod +x /usr/bin/chromedriver
```
## Run:
```
mvn test
```



