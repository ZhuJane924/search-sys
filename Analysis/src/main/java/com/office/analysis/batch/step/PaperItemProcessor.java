package com.office.analysis.batch.step;

import com.office.analysis.entity.Author;
import com.office.analysis.entity.Paper;
import com.office.analysis.service.AuthorPaperService;
import com.office.analysis.service.AuthorService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class PaperItemProcessor implements ItemProcessor<Paper, Paper> {

    @Resource
    private AuthorService authorService;

    @Resource
    private AuthorPaperService authorPaperService;

    @Override
    public Paper process(Paper paper) throws Exception {
        // 以a1字段为例（作者缩写），au字段为作者全名，均以分号分隔
        if (paper.getA1() != null && !paper.getA1().isEmpty()) {
            String[] initials = paper.getA1().split(";");
            String[] fullNames = paper.getAu() != null ? paper.getAu().split(";") : new String[initials.length];

            for (int i = 0; i < initials.length; i++) {
                String initial = initials[i].trim();
                String fullName = i < fullNames.length ? fullNames[i].trim() : "";
                // 这里 affiliation 字段可以从别的字段获取，暂时传null
                Author author = authorService.saveOrUpdateAuthor(initial, fullName, null);

                // 保存关联
                authorPaperService.saveRelation(author.getId(), paper.getId());
            }
        }

        // TODO: 其它辅助表类似处理

        return paper;
    }
}
