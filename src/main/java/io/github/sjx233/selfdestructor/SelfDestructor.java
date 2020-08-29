package io.github.sjx233.selfdestructor;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class SelfDestructor implements PreLaunchEntrypoint {
  @Override
  public void onPreLaunch() {
    try {
      Files.delete(Paths.get(SelfDestructor.class.getProtectionDomain().getCodeSource().getLocation().toURI()));
    } catch (Exception e) {
      LogManager.getLogger().error("Failed to delete myself.", e);
    }
  }
}
