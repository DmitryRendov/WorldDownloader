/*
 * This file is part of World Downloader: A mod to make backups of your
 * multiplayer worlds.
 * http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2520465
 *
 * Copyright (c) 2014 nairol, cubic72
 * Copyright (c) 2018 Pokechu22, julialy
 *
 * This project is licensed under the MMPLv2.  The full text of the MMPL can be
 * found in LICENSE.md, or online at https://github.com/iopleke/MMPLv2/blob/master/LICENSE.md
 * For information about this the MMPLv2, see http://stopmodreposts.org/
 *
 * Do not redistribute (in modified or unmodified form) without prior permission.
 */
package wdl.config;

import org.junit.Test;


import org.junit.Test;

public class StringSettingTest {

	@Test
	public void testConfig() {
		StringSetting setting = new StringSetting("test", "SOMETHING");
		Configuration config = new Configuration(new DefaultConfiguration());
		assertThat(config.getValue(setting), is("SOMETHING"));  // default value
		config.setValue(setting, "something");
		assertThat(config.getValue(setting), is("something"));
	}

	@Test
	public void testParse() {
		StringSetting setting = new StringSetting("test", "SOMETHING");
		assertThat(setting.deserializeFromString("SOMETHING"), is("SOMETHING"));
		assertThat(setting.deserializeFromString("This test really only exists to cover 7 instructions"), is("This test really only exists to cover 7 instructions"));
		assertThat(setting.serializeToString("SOMETHING"), is("SOMETHING"));
		assertThat(setting.serializeToString("It's remarkably silly, isn't it?"), is("It's remarkably silly, isn't it?"));
	}
}
