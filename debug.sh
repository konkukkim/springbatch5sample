java -jar target/primeiroprojetospringbatch-0.0.1-SNAPSHOT.jar --spring.batch.job.name=job nome=Test1 --debug 2>&1 | tee debug.log
grep -i -B2 -A10 "JobLauncherApplicationRunner" debug.log
