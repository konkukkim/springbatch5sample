./mvnw clean package -DskipTests
TIME=`date +%y%m%d%H%M`
java -jar target/springbatch5sample-0.0.1-SNAPSHOT.jar --spring.batch.job.name=testChunkJob param=${TIME}
echo '----------------------------------------------------'
echo 'SELECT max(processed_at) FROM springbatch503_schma.t_test2'
PGPASSWORD='1234' winpty psql -U postgres -d "clib_db" -A -q -t -c "SELECT max(processed_at) FROM springbatch503_schma.t_test2;"

