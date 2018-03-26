import time

import frida


def my_message_handler(message, payload):
    print message
    print payload


device = frida.get_usb_device()
pid = device.spawn(["asvid.github.io.fridaapp"])
device.resume(pid)
time.sleep(1)  # Without it Java.perform silently fails
session = device.attach(pid)
with open("change_method.js") as f:
# with open("instance.js") as f:
# with open("brutal.js") as f:
# with open("class_list.js") as f:
# with open("security.js") as f:
# with open("some_class.js") as f:
# with open("debug.js") as f:
    script = session.create_script(f.read())
script.on("message", my_message_handler)
script.load()

# prevent the python script from terminating
raw_input()