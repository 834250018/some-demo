querydsl使用
引入组件
plugins {
    id "com.ewerk.gradle.plugins.querydsl" version "1.0.9"
}
指定目录
querydsl {
    // use mongodb
    springDataMongo = true
    querydslSourcesDir = "$buildDir/generated/source/apt/main"
}
引入querydsl的生成目录
sourceSets {
    main {
        java {
            srcDir "$buildDir/generated/source/apt/main"
        }
    }
}

若querydsl找不到某些东西,比如说找不到lombok的符号,检查lombok的依赖模式,正确是使用compile

repository
public interface TestEntryRepository extends QueryDslPredicateExecutor<TestEntry> {
}