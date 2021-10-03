package utils;

public class Path {
    public static final String RESOURCES_FOLDER = "/resources";

    public static class Resources {
        public static final String ACTOR_FOLDER = RESOURCES_FOLDER + "/actors";
        public static final String OBJ_FOLDER = RESOURCES_FOLDER + "/objs";
        public static final String SOUND_FOLDER = RESOURCES_FOLDER + "/sounds";
        public static final String BACKGROUND_FOLDER = RESOURCES_FOLDER + "/backgrounds";

        public static class Actors {
            public static final String AIR_CRAFT = ACTOR_FOLDER + "/airplane1.png";
            public static final String ENEMY = ACTOR_FOLDER + "/enemy1.png";
        }
    }
}