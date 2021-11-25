job "example2" {
datacenters = ["dc1"]
type = "service"
update {
max_parallel = 1
min_healthy_time = "10s"
healthy_deadline = "3m"
progress_deadline = "10m"
auto_revert = false
canary = 0
}
migrate {
max_parallel = 1
health_check = "checks"
min_healthy_time = "10s"
healthy_deadline = "5m"
}
group "cache" {
count = 1
network {
port "db" {
to = 6379
}
}
service {
name = "redis-cache"
tags = ["global", "cache"]
port = "db"
}
restart {
attempts = 2
interval = "30m"
delay = "15s"
mode = "fail"
}
ephemeral_disk {
size = 300
}
task "lab3" {
driver = "java"
config {
jar_path = "local/lab3/target/ServiceCreate.jar"
jvm_options = ["-Xmx2048m", "-Xms256m"]
}
artifact {
source = "git::https://github.com/danielshulgin/TestBot.git"
destination = "local/lab3"
}
}
}
}
