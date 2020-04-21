package GOF23.Mediator;

/**
 * 核心：
 *   - 如果一个系统中对象之间的联系呈现为网状结构，对象之间存在大量多对多关系，将导致关系及其复杂
 *     这些对象为“同事对象”
 *   - 我们可以引入一个中介者对象，使各个同事对象只跟中介者对象打交道，将复杂的网络结构化化解为如下的星型
 *     结构
 *
 * 本质：
 *   - 解耦多个同事对象之间的交互关系。每个对象都持有中介者对象的引用，只跟中介者对象打交道。
 *     我们通过中介者对象统一管理这些交互关系。
 *
 *  场景：
 *   - MCV模式(其中C，控制器就是一个中介者对象，M和V都和他打交道)
 *   -窗口游戏程序，窗口软件开发中窗口对象也是一个中介者对象
 *   - GUI，多个组件之间的交互，可以通过引入一个中介者对象来解决，可以是整体的窗口对象或者DOM对象
 *   - Java.lang.reflect.Method#invoke()
 */
public interface Mediator {
    void register(String dname,Department d);
    void command(String dname);
}
