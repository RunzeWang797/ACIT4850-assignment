@RestController
public class Hello {

    @RequestMapping("/")
    public String sayHello(){
    //�޸ķ��ص��ַ���������
    return "abcdefg. Hello jenkins, " + new Date();
}
}
