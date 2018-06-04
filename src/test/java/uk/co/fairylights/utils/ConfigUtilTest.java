package uk.co.fairylights.utils;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by aurobindo on 03/06/2018.
 */
public class ConfigUtilTest {
    @Test
    public void readConfig_reads_configuration_properties() throws Exception {
        Properties properties = ConfigUtil.readConfig("testconfig");
        assertEquals(properties.getProperty("config1"), "value1");
        assertEquals(properties.getProperty("config2"), "value2");
    }
}