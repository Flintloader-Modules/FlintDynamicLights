/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of LambDynamicLights.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.lambdynlights;

import net.flintloader.loader.FlintLoader;

/**
 * Represents a utility class for compatibility.
 *
 * @author LambdAurora
 * @version 1.3.3
 * @since 1.0.0
 */
public final class LambDynLightsCompat {
	/**
	 * Returns whether Canvas is installed.
	 *
	 * @return {@code true} if Canvas is installed, else {@code false}
	 */
	public static boolean isCanvasInstalled() {
		return FlintLoader.isModuleLoaded("canvas");
	}

	/**
	 * Returns whether Lil Tater Reloaded is installed.
	 *
	 * @return {@code true} if LTR is installed, else {@code false}
	 */
	public static boolean isLilTaterReloadedInstalled() {
		// Don't even think about it Yog.
		return FlintLoader.isModuleLoaded("ltr");
	}

	/**
	 * Returns whether Embeddium is installed.
	 *
	 * @return {@code true} if Embeddium is installed, else {@code false}
	 */
	public static boolean isEmbeddiumInstalled() {
		return FlintLoader.isModuleLoaded("embeddium");
	}


	/**
	 * Returns whether Forgified Fabric API is installed.
	 *
	 * @return {@code true} if Forgified Fabric API is installed, else {@code false}
	 */
	public static boolean isForgifiedFabricApiInstalled() {
		return FlintLoader.isModuleLoaded("fabric_api");
	}
}
