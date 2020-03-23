package org.fakekoji.jobmanager.project;

import org.fakekoji.DataGenerator;
import org.fakekoji.jobmanager.ConfigManager;
import org.fakekoji.jobmanager.ManagementException;
import org.fakekoji.jobmanager.model.BuildJob;
import org.fakekoji.jobmanager.model.JDKProject;
import org.fakekoji.jobmanager.model.JDKTestProject;
import org.fakekoji.jobmanager.model.Job;
import org.fakekoji.jobmanager.model.Project;
import org.fakekoji.jobmanager.model.PullJob;
import org.fakekoji.jobmanager.model.TestJob;
import org.fakekoji.model.BuildProvider;
import org.fakekoji.model.JDKVersion;
import org.fakekoji.model.Platform;
import org.fakekoji.model.Task;
import org.fakekoji.model.TaskVariant;
import org.fakekoji.model.TaskVariantValue;
import org.fakekoji.storage.StorageException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.fakekoji.DataGenerator.BEAKER;
import static org.fakekoji.DataGenerator.PROJECT_NAME;
import static org.fakekoji.DataGenerator.TEST_PROJECT_NAME;
import static org.fakekoji.DataGenerator.VAGRANT;

public class JDKProjectParserTest {

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    private ConfigManager configManager;
    private File repositoriesRoot;
    private File configsRoot;
    private File scriptsRoot;

    private final JDKTestProject jdkTestProject = DataGenerator.getJDKTestProject();
    private final List<String> blacklist = jdkTestProject.getSubpackageBlacklist();
    private final List<String> whitelist = jdkTestProject.getSubpackageWhitelist();
    private final JDKVersion jdkVersion = DataGenerator.getJDKVersion8();
    private final Task tckTask = DataGenerator.getTCK();
    private final Task jtregTask = DataGenerator.getJTREG();
    private final Platform rhel7x64 = DataGenerator.getRHEL7x64();
    private final Platform f29x64 = DataGenerator.getF29x64();
    private final Set<BuildProvider> buildProviders = DataGenerator.getBuildProviders();


    @Before
    public void setup() throws IOException, StorageException {
        repositoriesRoot = temporaryFolder.newFolder("repositories");
        configsRoot = temporaryFolder.newFolder("configs");
        scriptsRoot = temporaryFolder.newFolder("scripts");
        DataGenerator.initConfigsRoot(configsRoot);
        configManager = ConfigManager.create(configsRoot.getAbsolutePath());
    }

    @Test
    public void parseJDKTestProject() throws StorageException, ManagementException {
        final Set<Job> expectedJobs = new HashSet<>(Arrays.asList(
                new TestJob(
                        VAGRANT,
                        TEST_PROJECT_NAME,
                        Project.ProjectType.JDK_TEST_PROJECT,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        tckTask,
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getGarbageCollectorCategory(), DataGenerator.getShenandoahVariant());
                                    put(DataGenerator.getDisplayProtocolCategory(), DataGenerator.getXServerVariant());
                                }}
                        ),
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getSlowdebugVariant());
                                }}
                        ),
                        blacklist,
                        whitelist,
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new TestJob(
                        VAGRANT,
                        TEST_PROJECT_NAME,
                        Project.ProjectType.JDK_TEST_PROJECT,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        tckTask,
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getGarbageCollectorCategory(), DataGenerator.getShenandoahVariant());
                                    put(DataGenerator.getDisplayProtocolCategory(), DataGenerator.getWaylandVariant());
                                }}
                        ),
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getSlowdebugVariant());
                                }}
                        ),
                        blacklist,
                        whitelist,
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new TestJob(
                        VAGRANT,
                        TEST_PROJECT_NAME,
                        Project.ProjectType.JDK_TEST_PROJECT,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        jtregTask,
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getGarbageCollectorCategory(), DataGenerator.getShenandoahVariant());
                                    put(DataGenerator.getDisplayProtocolCategory(), DataGenerator.getXServerVariant());
                                }}
                        ),
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getSlowdebugVariant());
                                }}
                        ),
                        blacklist,
                        whitelist,
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new TestJob(
                        VAGRANT,
                        TEST_PROJECT_NAME,
                        Project.ProjectType.JDK_TEST_PROJECT,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        tckTask,
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getGarbageCollectorCategory(), DataGenerator.getShenandoahVariant());
                                    put(DataGenerator.getDisplayProtocolCategory(), DataGenerator.getXServerVariant());
                                }}
                        ),
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getSlowdebugVariant());
                                }}
                        ),
                        blacklist,
                        whitelist,
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new TestJob(
                        VAGRANT,
                        TEST_PROJECT_NAME,
                        Project.ProjectType.JDK_TEST_PROJECT,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        tckTask,
                        f29x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getGarbageCollectorCategory(), DataGenerator.getShenandoahVariant());
                                    put(DataGenerator.getDisplayProtocolCategory(), DataGenerator.getWaylandVariant());
                                }}
                        ),
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getSlowdebugVariant());
                                }}
                        ),
                        blacklist,
                        whitelist,
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new TestJob(
                        VAGRANT,
                        TEST_PROJECT_NAME,
                        Project.ProjectType.JDK_TEST_PROJECT,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        tckTask,
                        f29x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getGarbageCollectorCategory(), DataGenerator.getShenandoahVariant());
                                    put(DataGenerator.getDisplayProtocolCategory(), DataGenerator.getXServerVariant());
                                }}
                        ),
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getSlowdebugVariant());
                                }}
                        ),
                        blacklist,
                        whitelist,
                        scriptsRoot,
                        Collections.emptyList()
                )
        ));

        final JDKProjectParser parser = new JDKProjectParser(configManager, repositoriesRoot, scriptsRoot);
        final Set<Job> actualJobs = parser.parse(jdkTestProject);
        Assert.assertEquals(
                "ParsedProject should be equal",
                expectedJobs,
                actualJobs
        );
    }

    @Test
    public void parseJDKProject() throws StorageException, ManagementException {
        final JDKProject jdkProject = DataGenerator.getJDKProject();
        final Task buildTask = DataGenerator.getBuildTask();
        final Set<BuildProvider> buildProviders = DataGenerator.getBuildProviders();

        final Set<Job> expectedJobs = new HashSet<>(Arrays.asList(
                new PullJob(
                        PROJECT_NAME,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        repositoriesRoot,
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new BuildJob(
                        BEAKER,
                        PROJECT_NAME,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        buildTask,
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getJvmVariant(), DataGenerator.getHotspotVariant());
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getReleaseVariant());
                                }}
                        ),
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new BuildJob(
                        BEAKER,
                        PROJECT_NAME,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        buildTask,
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getJvmVariant(), DataGenerator.getZeroVariant());
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getReleaseVariant());
                                }}
                        ),
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new TestJob(
                        VAGRANT,
                        PROJECT_NAME,
                        Project.ProjectType.JDK_PROJECT,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        tckTask,
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getGarbageCollectorCategory(), DataGenerator.getShenandoahVariant());
                                    put(DataGenerator.getDisplayProtocolCategory(), DataGenerator.getXServerVariant());
                                }}
                        ),
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getJvmVariant(), DataGenerator.getHotspotVariant());
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getReleaseVariant());
                                }}
                        ),
                        scriptsRoot,
                        Collections.emptyList()
                ),
                new TestJob(
                        BEAKER,
                        PROJECT_NAME,
                        Project.ProjectType.JDK_PROJECT,
                        DataGenerator.getJDK8Product(),
                        jdkVersion,
                        buildProviders,
                        tckTask,
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getGarbageCollectorCategory(), DataGenerator.getShenandoahVariant());
                                    put(DataGenerator.getDisplayProtocolCategory(), DataGenerator.getXServerVariant());
                                }}
                        ),
                        rhel7x64,
                        Collections.unmodifiableMap(
                                new HashMap<TaskVariant, TaskVariantValue>() {{
                                    put(DataGenerator.getJvmVariant(), DataGenerator.getZeroVariant());
                                    put(DataGenerator.getDebugModeVariant(), DataGenerator.getReleaseVariant());
                                }}
                        ),
                        scriptsRoot,
                        Collections.emptyList()
                )
        ));

        final JDKProjectParser parser = new JDKProjectParser(configManager, repositoriesRoot, scriptsRoot);
        final Set<Job> actualJobs = parser.parse(jdkProject);
        Assert.assertEquals(
                "ParsedProject should be equal",
                expectedJobs,
                actualJobs
        );
    }
}