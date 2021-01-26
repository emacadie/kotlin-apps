package info.shelfunit.tutorial.module12;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JMeeting {
    private String title;

    @Nullable
    public String meetingTitle() {
        return title;
    }

    public void addTitle( @NotNull String title ) {
        this.title = title;
    }

    public String titleCanBeNull() {
        return title;
    }
}
