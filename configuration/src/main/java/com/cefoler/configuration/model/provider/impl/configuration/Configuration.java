package com.cefoler.configuration.model.provider.impl.configuration;

import com.cefoler.configuration.model.provider.Module;
import com.cefoler.configuration.model.provider.impl.configuration.type.ConfigurationType;
import java.io.File;
import java.io.FileNotFoundException;
import org.jetbrains.annotations.Nullable;

public interface Configuration extends Module {

  void load() throws FileNotFoundException;

  void save() throws FileNotFoundException;

  void saveAndLoad() throws FileNotFoundException;

  void set(final String path, @Nullable final Object object);

  File getFile();

  ConfigurationType getType();

}
