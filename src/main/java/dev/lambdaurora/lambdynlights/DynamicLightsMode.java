/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of LambDynamicLights.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.lambdynlights;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

/**
 * Represents the dynamic lights mode.
 *
 * @author LambdAurora
 * @version 2.0.1
 * @since 1.0.0
 */
public enum DynamicLightsMode {
	OFF(0, Formatting.RED, Text.literal("OFF")),
	FASTEST(500, Formatting.GOLD, Text.literal("FASTEST")),
	FAST(250, Formatting.YELLOW, Text.literal("FAST")),
	FANCY(0, Formatting.GREEN, Text.literal("FANCY"));

	private final int delay;
	private final Text translatedText;

	DynamicLightsMode(int delay, @NotNull Formatting formatting, @NotNull Text translatedText) {
		this.delay = delay;
		this.translatedText = translatedText.copy().formatted(formatting);
	}

	/**
	 * Returns whether this mode enables dynamic lights.
	 *
	 * @return {@code true} if the mode enables dynamic lights, else {@code false}
	 */
	public boolean isEnabled() {
		return this != OFF;
	}

	/**
	 * Returns whether this mode has an update delay.
	 *
	 * @return {@code true} if the mode has an update delay, else {@code false}
	 */
	public boolean hasDelay() {
		return this.delay != 0;
	}

	/**
	 * Returns the update delay of this mode.
	 *
	 * @return the mode's update delay
	 */
	public int getDelay() {
		return this.delay;
	}

	/**
	 * Returns the next dynamic lights mode available.
	 *
	 * @return the next available dynamic lights mode
	 */
	public DynamicLightsMode next() {
		DynamicLightsMode[] v = values();
		if (v.length == this.ordinal() + 1)
			return v[0];
		return v[this.ordinal() + 1];
	}

	/**
	 * Returns the translated text of the dynamic lights mode.
	 *
	 * @return the translated text of the dynamic lights mode
	 */
	public @NotNull Text getTranslatedText() {
		return this.translatedText;
	}

	public @NotNull String getName() {
		return this.name().toLowerCase();
	}

	/**
	 * Gets the dynamic lights mode from its identifier.
	 *
	 * @param id the identifier of the dynamic lights mode
	 * @return the dynamic lights mode if found, else empty
	 */
	public static @NotNull Optional<DynamicLightsMode> byId(@NotNull String id) {
		return Arrays.stream(values()).filter(mode -> mode.getName().equalsIgnoreCase(id)).findFirst();
	}
}
