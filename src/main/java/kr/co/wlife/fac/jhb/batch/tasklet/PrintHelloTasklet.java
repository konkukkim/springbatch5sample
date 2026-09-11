package kr.co.wlife.fac.jhb.batch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

public class PrintHelloTasklet implements Tasklet {

	@Value("#{jobParameters['nome']}")
	private String nome;

	private final JdbcTemplate jdbcTemplate;

	public PrintHelloTasklet(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("Olá, " + nome + " !");
		jdbcTemplate.update("INSERT INTO T_TEST1 (col1) VALUES (?)", "test");
		return RepeatStatus.FINISHED;
	}
}