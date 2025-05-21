package com.office.analysis.batch.step;

import com.office.analysis.entity.Paper;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.PostgresPagingQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class PaperItemReader {

    @Bean
    public JdbcPagingItemReader<Paper> reader(DataSource dataSource) {
        JdbcPagingItemReader<Paper> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource);
        reader.setPageSize(100);
        reader.setRowMapper(new BeanPropertyRowMapper<>(Paper.class));

        PostgresPagingQueryProvider queryProvider = new PostgresPagingQueryProvider();
        queryProvider.setSelectClause("id, a1, au"); // 只读取我们需要的字段
        queryProvider.setFromClause("from pubmed_raw");
        queryProvider.setSortKeys(Map.of("id", org.springframework.batch.item.database.Order.ASCENDING));
        reader.setQueryProvider(queryProvider);

        return reader;
    }
}
