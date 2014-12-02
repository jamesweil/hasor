/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.rsf._test;
import net.hasor.rsf.plugins.local.LocalPrefPlugin;
import net.hasor.rsf.plugins.qps.QPSPlugin;
import net.hasor.rsf.runtime.RsfBinder;
import net.hasor.rsf.runtime.RsfContext;
import net.hasor.rsf.runtime.server.RsfServer;
/**
 * 
 * @version : 2014年9月12日
 * @author 赵永春(zyc@hasor.net)
 */
public class Server {
    public static void main(String[] args) throws Exception {
        RsfContext rsfContext = new ServerRsfContext();
        RsfBinder rsfBinder = rsfContext.getRegisterCenter().getRsfBinder();
        rsfBinder.bindFilter(new QPSPlugin());
        rsfBinder.bindFilter(new LocalPrefPlugin());
        rsfBinder.bindService(ITestServices.class, new TestServices()).register();
        //TestServices
        RsfServer server = new RsfServer(rsfContext);
        //
        server.start();
    }
}