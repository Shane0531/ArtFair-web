SYLC Art Fair Web
=================

frontend build
--------------

resources/static
1. npm install

npm run-script watch -> dev
npm run-script build -> production



Server Setup
------------

sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install openjdk-8-jdk
sudo update-alternatives --config java
apt-get install mysql-server-5.6
iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080


Deploy
------

cap production deploy:java

