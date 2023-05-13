package designpatterntest;

import org.apache.commons.lang.StringUtils;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-11-27
 */
public class Config {

    /**
     * 配置名称
     */
    private String name;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 更新时间
     */
    private long updateTime;
    /**
     * 配置项1
     */
    private int config1;
    /**
     * 配置项2
     */
    private int config2;
    private String config3;
    private String config4;

    private Config() {
    }


    public static final class ConfigBuilder {
        private String name;
        private long createTime;
        private long updateTime;
        private int config1;
        private int config2;
        private String config3;
        private String config4;

        private ConfigBuilder() {
        }

        public static ConfigBuilder aConfig() {
            return new ConfigBuilder();
        }

        public ConfigBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ConfigBuilder withCreateTime(long createTime) {
            this.createTime = createTime;
            return this;
        }

        public ConfigBuilder withUpdateTime(long updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public ConfigBuilder withConfig1(int config1) {
            this.config1 = config1;
            return this;
        }

        public ConfigBuilder withConfig2(int config2) {
            this.config2 = config2;
            return this;
        }

        public ConfigBuilder withConfig3(String config3) {
            this.config3 = config3;
            return this;
        }

        public ConfigBuilder withConfig4(String config4) {
            this.config4 = config4;
            return this;
        }

        public Config build() {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name不能为空");
            }
            if (createTime <= 0) {
                throw new IllegalArgumentException("createTime不能为空");
            }
            if (config1 >= 0 && config2 >= 0 && config1 <= config2) {
                throw new IllegalArgumentException("config1要大于config2");
            }
            Config config = new Config();
            config.config4 = this.config4;
            config.config3 = this.config3;
            config.name = this.name;
            config.updateTime = this.updateTime;
            config.config2 = this.config2;
            config.config1 = this.config1;
            config.createTime = this.createTime;
            return config;
        }
    }

}
