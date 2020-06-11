package com.kelly.producer.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data // 包含@ToString,@EqualsAndHashCode,@Getter/@Setter,@RequiredArgsConstructor的功能
@Entity //自动见表
//下面注解，用于避免因延迟加载导致的数据转换报错
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","fieldHandler"})
public class Depart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
