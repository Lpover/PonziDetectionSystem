package cn.qkl.webserver.vo.cockpit.integrated;

import cn.qkl.common.repository.model.VocabCloud;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import static cn.qkl.common.framework.util.FunctionUtil.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 11:05
 **/

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VocabCloudViewVO extends ViewVO {

    private List<VocabNumPair> viewData;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class VocabNumPair {
        private String vocab;

        private Integer num;
    }

    public static VocabCloudViewVO transformFromVocabCloud(List<VocabCloud> vocabCloudList) {
        return apply(new VocabCloudViewVO(), it -> {
            it.viewData = new ArrayList<>();
            for (VocabCloud vocabCloud: vocabCloudList) {
                it.viewData.add(apply(new VocabNumPair(), pair -> {
                    pair.vocab = vocabCloud.getVocab();
                    pair.num = vocabCloud.getNum();
                }));
            }
        });
    }

}
