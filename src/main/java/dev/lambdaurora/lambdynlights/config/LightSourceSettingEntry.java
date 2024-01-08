/*
 * Copyright © 2021 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of LambDynamicLights.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.lambdynlights.config;

import net.flintloader.libs.moonconfig.core.Config;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class LightSourceSettingEntry extends BooleanSettingEntry {
	public LightSourceSettingEntry(String key, boolean defaultValue, @Nullable Config config, @Nullable Text tooltip) {
		super(key, defaultValue, config, tooltip);
	}

	public LightSourceSettingEntry(String key, boolean defaultValue, @Nullable Config config) {
		super(key, defaultValue, config);
	}
}
