package org.apache.airavata.helix.task.async.command;

import org.apache.airavata.helix.api.HelixParticipant;
import org.apache.airavata.k8s.api.resources.task.type.TaskTypeResource;
import org.apache.helix.task.Task;
import org.apache.helix.task.TaskCallbackContext;
import org.apache.helix.task.TaskFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Class level comments please
 *
 * @author dimuthu
 * @since 1.0.0-SNAPSHOT
 */
public class Participant extends HelixParticipant {

    public Participant(String propertyFile) throws IOException {
        super(propertyFile);
    }

    @Override
    public Map<String, TaskFactory> getTaskFactory() {
        Map<String, TaskFactory> taskRegistry = new HashMap<String, TaskFactory>();

        TaskFactory commandTaskFac = new TaskFactory() {
            @Override
            public Task createNewTask(TaskCallbackContext context) {
                return new AsyncCommandTask(context, getPropertyResolver());
            }
        };

        taskRegistry.put(AsyncCommandTask.NAME, commandTaskFac);

        return taskRegistry;
    }

    @Override
    public TaskTypeResource getTaskType() {
        return AsyncCommandTask.getTaskType();
    }

    public static void main(String args[]) {
        try {
            HelixParticipant participant = new Participant("application.properties");
            new Thread(participant).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
