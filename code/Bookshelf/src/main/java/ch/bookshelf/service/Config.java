package ch.bookshelf.service;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

    @ApplicationPath("/resource")
public class Config extends Application {
        /**
         * define all provider classes
         *
         * @return set of classes
         */
        @Override
        public Set<Class<?>> getClasses() {
            HashSet providers = new HashSet<Class<?>>();
            providers.add(TestService.class);
            return providers;
        }
}
