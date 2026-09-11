TIME=`date +%y%m%d%H%M`
java -jar target/primeiroprojetospringbatch-0.0.1-SNAPSHOT.jar --spring.batch.job.name=testChunkJob param=${TIME}
