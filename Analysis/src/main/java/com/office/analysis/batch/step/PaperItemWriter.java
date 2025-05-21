package com.office.analysis.batch.step;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.office.analysis.entity.Paper;
import java.util.List;

@Component
public class PaperItemWriter implements ItemWriter<Paper> {

    @Override
    public void write(Chunk<? extends Paper> items) throws Exception {
        List<? extends Paper> itemList = items.getItems();
        System.out.println("写入 " + itemList.size() + " 条 Paper 数据");
        // 这里写你具体的写入逻辑
    }
}
